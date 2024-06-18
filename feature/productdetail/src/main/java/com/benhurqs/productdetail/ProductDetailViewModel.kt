package com.benhurqs.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benhurqs.datalayer.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class ProductDetailViewModel(  private val repository: ProductsRepository
): ViewModel() {

    private var _status: MutableLiveData<ProductDetailActions> = MutableLiveData()
    val status: LiveData<ProductDetailActions> = _status

    fun fetchProduct(id: Int){
        viewModelScope.launch {
            try {
                repository.getProductDetail(id).flowOn(Dispatchers.IO)
                    .catch {
                        _status.postValue(ProductDetailActions.ShowError)
                    }.collect { product ->
                        if(product != null) {
                            _status.postValue(ProductDetailActions.LoadProduct(product))
                        }else{
                            _status.postValue(ProductDetailActions.ShowError)
                        }
                    }
            }catch (e: SocketTimeoutException){
                _status.postValue(ProductDetailActions.ShowError)
            }
        }
    }
}