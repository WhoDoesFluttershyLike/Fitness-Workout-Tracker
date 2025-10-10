package repository

import (
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/models"
	"gorm.io/gorm"
)

type UserRepository interface {
	Create(user *models.User) error
	GetById(id uint) (*models.User, error)
	GetByEmail(email string) (*models.User, error)
}

type userRepository struct {
	db *gorm.DB
}

// Create implements UserRepository.
func (u *userRepository) Create(user *models.User) error {
	panic("unimplemented")
}

// GetByEmail implements UserRepository.
func (u *userRepository) GetByEmail(email string) (*models.User, error) {
	panic("unimplemented")
}

// GetById implements UserRepository.
func (u *userRepository) GetById(id uint) (*models.User, error) {
	panic("unimplemented")
}

func NewUserRepository(db *gorm.DB) UserRepository {
	return &userRepository{db: db}
}
