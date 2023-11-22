package com.ddorocare.brand_audit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ddorocare.brand_audit.model.GraphDetailResponse

class GraphViewModel : ViewModel() {
    private val repository: Repository = Repository()

    fun getGraphData(): LiveData<ResultCustom<List<GraphDetailResponse>>> {
        return repository.getGraphData()
    }

}