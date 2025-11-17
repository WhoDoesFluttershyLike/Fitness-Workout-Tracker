package service

import (
	"errors"

	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/auth"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/models"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/repository"
	"golang.org/x/crypto/bcrypt"
)

type UserService struct {
	repo repository.UserRepository
}

func NewUserService(repo repository.UserRepository) *UserService {
	return &UserService{repo: repo}
}

func (s *UserService) Register(name, email, password string) error {
	exist, _ := s.repo.GetByEmail(email)
	if exist != nil {
		return errors.New("email already in use")
	}

	hashedPassword, err := bcrypt.GenerateFromPassword([]byte(password), bcrypt.DefaultCost)
	if err != nil {
		return err
	}

	user := &models.User{
		Username: name,
		Email:    email,
		Password: string(hashedPassword),
	}
	return s.repo.Create(user)
}

func (s *UserService) Login(email, password string) (string, error) {

	user, err := s.repo.GetByEmail(email)
	if err != nil {
		return "", errors.New("invalid email or password")
	}

	err = bcrypt.CompareHashAndPassword([]byte(user.Password), []byte(password))
	if err != nil {
		return "", errors.New("invalid email or password")
	}

	token, err := auth.GenerateToken(user.ID, user.Email)
	if err != nil {
		return "", errors.New("failed to generate token")
	}

	return token, nil
}
