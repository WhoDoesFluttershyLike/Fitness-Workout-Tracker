package main

import (
	"fmt"
	"log"
	router "github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/api-gateway/routes"
)

func main() {
    r := router.SetupRouter()

    fmt.Println("API Gateway running on :8000")

    if err := r.Run(":8000"); err != nil {
        log.Fatalf("Failed to start server: %v", err)
    }
}
