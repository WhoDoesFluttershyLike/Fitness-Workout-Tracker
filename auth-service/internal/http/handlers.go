package http

import(
	"net/http"

    "github.com/gin-gonic/gin"
	"github.com/WhoDoesFluttershyLike/Fitness-Workout-Tracker/auth-service/internal/service"
)

type Handler struct {
}

func NewHandler() *Handler {
    return &Handler{}
}

func (h *Handler) Register(c *gin.Context) {
   
    c.JSON(http.StatusOK, gin.H{"message": "register endpoint"})
}

func (h *Handler) Login(c *gin.Context) {
    c.JSON(http.StatusOK, gin.H{"message": "login endpoint"})
}