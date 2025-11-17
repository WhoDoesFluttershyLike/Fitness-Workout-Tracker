package http

import (
	"github.com/gin-gonic/gin"
)

func SetupRouter(h *Handler) *gin.Engine {
    r := gin.Default()

    api := r.Group("/api/v1/users") 
    {
        api.POST("/register", h.Register)
        api.POST("/login", h.Login)
    }

    return r
}



