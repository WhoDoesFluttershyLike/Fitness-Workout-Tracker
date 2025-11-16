package http

import (
	"net/http"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/service"
	"github.com/gin-gonic/gin"
)

type Handler struct {
    svc *service.UserService
}

type RegisterInput struct {
    Name     string `json:"name"`
    Email    string `json:"email"`
    Password string `json:"password"`
}

func NewHandler(s *service.UserService) *Handler {
    return &Handler{svc: s}
}

func (h *Handler) Register(c *gin.Context) {
    var input RegisterInput
    if err := c.ShouldBindJSON(&input); err != nil {
        c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
        return
    }

    if err := h.svc.Register(input.Name, input.Email, input.Password); err != nil {
        c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
        return
    }
    c.JSON(http.StatusOK, gin.H{"message": "register endpoint"})
}

func (h *Handler) Login(c *gin.Context) {
    var input RegisterInput
    if err := c.ShouldBindJSON(&input); err != nil {
        c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
        return
    }

    token, err := h.svc.Login(input.Email, input.Password)
    if err != nil {
        c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
        return
    }
    c.JSON(http.StatusOK, gin.H{"token": token})
}