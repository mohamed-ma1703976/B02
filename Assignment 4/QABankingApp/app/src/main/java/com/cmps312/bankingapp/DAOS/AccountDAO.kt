import androidx.lifecycle.LiveData
import com.cmps312.bankingapp.models.Account
import androidx.room.*
@Dao
interface AccountDAO {
    @Query("select * from Account where acctType = acctType")
    suspend fun getAccounts(acctType:String) : LiveData<List<Account>>
    @Query("select * from Account Where accountNo = accountNo")
    suspend fun getAccount(accountNo: String) : Account?
    @Insert
    suspend fun insert(account: Account)
    @Update
    suspend fun update(accountNo: String,account: Account)
    @Delete
    suspend fun delete(account: Account)

}