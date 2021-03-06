package creamy.activity.requestor;

import creamy.activity.Activity;
import creamy.browser.Broker;

/**
 * 動的リクエストのAPIを提供する抽象クラス。
 * creamy.activity.Activityがこのクラスを継承し、ユーザにリクエストAPIを提供する
 * 
 * @author miyabetaiji
 */
public abstract class Requestor {
    /**
     * アクティビティをリクエストするRequestオブジェクトを返す
     * @param path Request送信先パス
     * @return request Requestオブジェクト
     */
    protected Request<Activity> requestActivity(String path) {
        Request<Activity> request = new ActivityRequest(createBroker());
        request.setPath(path);
        request.setParent((Activity)this);
        return request;
    }
    /**
     * データ(Object)をリクエストするRequestオブジェクトを返す
     * @param path Request送信先パス
     * @return request Requestオブジェクト
     */
    protected Request<Object> requestData(String path) {
        Request<Object> request = new DataRequest(createBroker());
        request.setPath(path);
        return request;
    }
    /**
     * リクエストに使用するBrokerオブジェクトを生成する
     * @return broker リクエストに使用するブローカ
     */
    protected abstract Broker createBroker();
    /**
     * リクエストをキャンセルする
     */
    protected void cancelRequest() {
        throw new RequestCancel();
    }
}
