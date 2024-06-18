package com.benhurqs.productdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benhurqs.base.actions.Actions
import com.benhurqs.base.views.components.ErrorView
import com.benhurqs.base.views.utils.formatPrice
import com.benhurqs.base.views.utils.loadImageInto
import com.benhurqs.datalayer.Product
import com.benhurqs.productdetail.databinding.ProductDetailActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailActivity: AppCompatActivity() {
    private val viewModel: ProductDetailViewModel by viewModel()
    private lateinit var binding: ProductDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchProduct(intent.getIntExtra(Actions.PRODUCT_ID_KEY, -1))
        viewModel.status.observe(this){ status ->
            when(status){
                is ProductDetailActions.ShowError -> ErrorView.makeContent(this){
                    this@ProductDetailActivity.finish()
                }.show()
                is ProductDetailActions.LoadProduct -> loadProduct(status.product)
            }
        }

        binding.productDetailClose.setOnClickListener { this.finish() }
        binding.productDetailCartButton.setOnClickListener {
            //Add to cart
        }
    }

    private fun loadProduct(product: Product){
        product.image?.loadImageInto(this, binding.productDetailImage)
        binding.productDetailCategory.text = product.category
        binding.productDetailName.text = product.title
        binding.productDetailDescription.text = product.description
        binding.productDetailPrice.text = product.price?.formatPrice()
        binding.productDetailQtd.text = getString(R.string.product_qtd, product.count)
        binding.productDetailRating.text = product.rate.toString()
    }
}