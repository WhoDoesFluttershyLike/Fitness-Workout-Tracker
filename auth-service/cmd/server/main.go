package main

import (
	"log"

	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/db"
)

func main() {
	//db configuration
	cfg := db.LoadConfig()

	// connect to db
	database, err := db.NewPostgresConnection(cfg)
	if err != nil {
		log.Fatalf("DB connection error: %v", err)
	}
	defer database.Close()

	// check connection
	log.Println("Everything initialized. Ready to build services.")
}
