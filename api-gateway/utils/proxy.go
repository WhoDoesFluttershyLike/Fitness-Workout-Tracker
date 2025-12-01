package utils

import (
    "io"
    "net/http"
    "net/url"

    "github.com/gin-gonic/gin"
)

func ProxyRequest(c *gin.Context, target string) {

	remote, err := url.Parse(target)
    if err != nil {
        c.JSON(http.StatusInternalServerError, gin.H{"error": "Invalid target URL"})
        return
    }

    remote.Path = c.Param("path")

    req, err := http.NewRequest(c.Request.Method, remote.String(), c.Request.Body)
    if err != nil {
        c.JSON(http.StatusInternalServerError, gin.H{"error": "Failed to create request"})
        return
    }

    for key, values := range c.Request.Header {
        for _, v := range values {
            req.Header.Add(key, v)
        }
    }

    client := &http.Client{}
    resp, err := client.Do(req)
    if err != nil {
        c.JSON(http.StatusBadGateway, gin.H{"error": "Service unreachable"})
        return
    }
    defer resp.Body.Close()

    for key, values := range resp.Header {
        for _, v := range values {
            c.Writer.Header().Add(key, v)
        }
    }

    c.Writer.WriteHeader(resp.StatusCode)

    io.Copy(c.Writer, resp.Body)
}
