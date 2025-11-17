package db

import (
	"gorm.io/driver/postgres"

	_ "github.com/lib/pq"
	"gorm.io/gorm"
)

func NewPostgresConnection(cfg *Config) (*gorm.DB, error) {
	
	db, err := gorm.Open(postgres.Open(cfg.DSN()), &gorm.Config{})
	if err != nil {
		return nil, err
	}

	return db, nil
}
