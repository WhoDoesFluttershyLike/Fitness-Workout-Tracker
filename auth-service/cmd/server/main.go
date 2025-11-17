package main

import (
	"log"

	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/db"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/repository"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/http"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/service"
)

func main() {
	//db configuration
	cfg := db.LoadConfig()

	// connect to db
	database, err := db.NewPostgresConnection(cfg)
	if err != nil {
		log.Fatalf("DB connection error: %v", err)
	}
	// check connection
	log.Println("Everything initialized. Ready to build services.")

	// init layers
    repo := repository.NewUserRepository(database)
    srv := service.NewUserService(repo)
    handler := http.NewHandler(srv)

    // gin router
    http.SetupRouter(handler).Run(":8080")
}
