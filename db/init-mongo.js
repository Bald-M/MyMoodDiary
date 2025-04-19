/**
 * MongoDB initialization script for Docker container
 * Executed automatically on first container startup
 */
// Create and switch to application database
db = db.getSiblingDB("my-mood-diary")
// Initialize core collection for mood cards
db.createCollection("mood-cards")
/**
 * Create application user with privileges
 * @param {string} user - Database username
 * @param {string} pwd - Strong password
 * @param {array} roles - Assigned permissions
 */
db.createUser(
  {
      user: "user",
      pwd: "ABCabc-123",
      roles: [
          {
              role: "readWrite",
              db: "my-mood-diary"
          }
      ]
  }
)