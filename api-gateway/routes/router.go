package router

import (
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/api-gateway/config"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/api-gateway/middleware"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/api-gateway/utils"
	"github.com/gin-gonic/gin"
)

func SetupRouter() *gin.Engine {
    r := gin.Default()

    
    r.GET("/health", func(c *gin.Context) {
        c.JSON(200, gin.H{"status": "ok"})
    })

   
    auth := r.Group("/")
    auth.Use(middleware.AuthMiddleware())

    
    auth.Any("/users/*path", func(c *gin.Context) {
        utils.ProxyRequest(c, config.UserServiceURL) // user-service
    })

    auth.Any("/workouts/*path", func(c *gin.Context) {
        utils.ProxyRequest(c, config.WorkoutServiceURL) // workout-service
    })

    return r
}
