package kg.geektech.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.geektech.taskapp.databinding.ActivityMainBinding
import kg.geektech.taskapp.domain.ShopItem
import kg.geektech.taskapp.presenteition.MainViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var viewModel: MainViewModel
    private val binding by viewBinding(ActivityMainBinding::bind, R.id.main_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initObservers()
        initListeners()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initListeners() {
        //add shopItem
        binding.btnAddShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.addShopItem(ShopItem(binding.editText.text.toString(), 2, true))
            Toast.makeText(this,"asdad  ${viewModel.shopListLD}", Toast.LENGTH_SHORT).show()
        }
        //edit ShopItem
        binding.btnEditShopItem.setOnClickListener {
            val text = viewModel.getShopItem(binding.editText.text.toString().toInt())
            viewModel.editShopItem(text)
            Toast.makeText(this,"asdad  ${viewModel.shopListLD}", Toast.LENGTH_SHORT).show()
        }
        //delete ShopItem
        binding.btnDeleteShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.deleteShopItem(ShopItem(binding.editText.text.toString(), 2, true))
            Toast.makeText(this,"asdad  ${viewModel.shopListLD}", Toast.LENGTH_SHORT).show()
        }
        //get shopItem
        binding.btnGetShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.getShopItem(binding.editText.text.toString().toInt())
            Toast.makeText(this,"asdad  ${viewModel.shopListLD}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this) {
            Toast.makeText(applicationContext, "получили данные", Toast.LENGTH_LONG).show()
        }
    }
}