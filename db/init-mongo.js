/**
 * MongoDB initialization script for Docker container
 * Executed automatically on first container startup
 */

// Switch to admin database for authentication
db = db.getSiblingDB("admin")

/**
 * Create application user with privileges
 * @param {string} user - Database username
 * @param {string} pwd - Strong password
 * @param {array} roles - Assigned permissions
 */
db.createUser({
  user: "user",
  pwd: "ABCabc-123",
  roles: [
    // Global user administration privileges
    { role: "userAdminAnyDatabase", db: "my-mood-diary" },
    // Read/write access to all collections
    { role: "readWriteAnyDatabase", db: "my-mood-diary" }
  ]
})

// Create and switch to application database
db = db.getSiblingDB("my-mood-diary")

// Initialize core collection for mood cards
db.createCollection("mood-cards")