package com.curymorais.kotlinlearn

interface KotlinLearnContract {

    interface View{
        fun initComponents()
        fun setComponentListeners()
//        fun showProgress()
//        fun hideProgress()
//        fun setDataToRecyclerView(gameArrayList: List<Game>)
//        fun onResponseFailure(throwable: Throwable)
    }

    interface Presenter {
//        fun onDestroy()
//        fun onRefreshButtonClick()
//        fun requestDataFromServer()
    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     */
    interface Interactor {

        interface OnFinishedListener {
            //            void onFinished(ArrayList<Notice> noticeArrayList);
//            fun onFinished(gameArrayList: List<Game>)

//            fun onFailure(t: Throwable)
        }

//        fun getGameArrayList(onFinishedListener: OnFinishedListener)
    }

}