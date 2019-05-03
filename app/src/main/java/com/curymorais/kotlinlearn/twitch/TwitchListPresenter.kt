package com.curymorais.kotlinlearn.twitch

import com.curymorais.kotlinlearn.KotlinLearnContract


//class TwitchListPresenter(twitchListFragment: KotlinLearnContract.View, twitchListInteractor: KotlinLearnContract.Interactor): KotlinLearnContract.Presenter {
class TwitchListPresenter : KotlinLearnContract.Presenter {

    var mView : KotlinLearnContract.View? = null
    var mInteractor : KotlinLearnContract.Interactor? = null

    constructor (view : KotlinLearnContract.View,  interactor : KotlinLearnContract.Interactor) {
        mView = view
        mInteractor = interactor
    }

//    public void loadGames(){
//        mGameService.getTopGameList();
//    }
//
//
//    @Override
//    public void onDestroy() {
//        mView = null;
//    }
//
//    @Override
//    public void onRefreshButtonClick() {
//        if(mView != null){
//            mView.showProgress();
//        }
//        mInteractor.getGameArrayList(this);
//    }
//
//    @Override
//    public void requestDataFromServer() {
//        mInteractor.getGameArrayList(this);
//    }
//
//    @Override
//    public void onFinished(List<Game> gameArrayList) {
//        if(mView != null){
//            mView.setDataToRecyclerView(gameArrayList);
//            mView.hideProgress();
//        }
//    }
//
//    @Override
//    public void onFailure(Throwable t) {
//        if(mView != null){
//            mView.onResponseFailure(t);
//            mView.hideProgress();
//        }
//    }
}