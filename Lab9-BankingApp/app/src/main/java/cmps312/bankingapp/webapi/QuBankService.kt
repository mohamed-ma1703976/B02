package cmps312.bankingapp.webapi

import cmps312.bankingapp.model.Account
import cmps312.bankingapp.model.Beneficiary
import cmps312.bankingapp.model.Transfer
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonConfiguration

class QuBankService : BankService {
    private val BASE_URL = "https://cmps312banking.herokuapp.com/api"
    private val client = HttpClient {
        //This will auto-parse from/to json when sending and receiving data from Web API
        install(JsonFeature)  {
            serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getTransfers(cid: Int): List<Transfer> {
        val url = "$BASE_URL/transfers/$cid"
        return client.get(url)
    }

    override suspend fun addTransfer(transfer: Transfer): Transfer {
        return client.post {
            url("$BASE_URL/transfers/${transfer.cid}")
            contentType(ContentType.Application.Json)
            body = transfer
        }
    }

    override suspend fun deleteTransfer(cid: Int, transferId: String): String {
        val url = "$BASE_URL/transfers/$cid/$transferId"
        return client.delete(url)
    }

    override suspend fun getAccounts(cid: Int): List<Account> {
        val url = "$BASE_URL/accounts/$cid"
        return client.get(url)
    }

    override suspend fun getBeneficiaries(cid: Int): List<Beneficiary> {
        val url = "$BASE_URL/beneficiaries/$cid"
        return client.get(url)
    }

    override suspend fun updateBeneficiary(cid: Int, beneficiary: Beneficiary): String? {
        val url = "$BASE_URL/beneficiaries/$cid"
        return client.put {
            url(url)
            contentType(ContentType.Application.Json)
            body = beneficiary
        }
    }

    override suspend fun deleteBeneficiary(cid: Int, accountNo: Int): String {
        val url = "$BASE_URL/beneficiaries/$cid/$accountNo"
        return client.delete(url)
    }
}