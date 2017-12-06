package restapi.repository

import restapi.model.User

interface UserRepository : CrudRepository<User, Long> {
}