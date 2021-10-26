package cmps312.bankingapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val accountNo: String,
    val firstName: String,
    val lastName: String,
    val type: String,
    val balance: Double)
{
    override fun toString() = "$accountNo - $firstName $lastName ($type) $balance"
}
