package action;


import org.apache.struts2.config.Result; //アノテーション用 (@result)
import org.apache.struts2.dispatcher.ServletRedirectResult;

// [アノテーション]
// このクラスのメソッドの返却値(return)によって対応したアクションに振り分ける
// 今回はreturnがmainだった場合、main.actionに飛ぶように設定している。
@Result(name = "main", value = "main.action", type = ServletRedirectResult.class)


public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// このアクションの変数とjspのname属性はリンクしている。
	// 同じ名前にしないと値を受け取れないしJSPに返せない。
	public String errmsg;
	public String userId;
	public String password;

	/*
	 * URLに直接アクション名.actionでアクセスされた時に動作する。
	 * 例) http://localhost:8080/login.action
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		this.sessionMap.put("userId", null);
		this.userId = "Struts2";

		// "アクション名" + return値-.jsp(login-success.jsp) を探すが、見つからないのでlogin.jsp の呼び出される。
		return "success";

	}

	/*
	 * サブミットボタン押下時、loginメソッドが指定された場合に動作する。
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@SuppressWarnings("unchecked")
	public String login() throws Exception {

		//パスワードのテキストボックスに"pass"以外の文字列が入力されいる場合は
		//このクラスのexecuteメソッドが呼び出され、
		if(this.password == null || !this.password.equals("pass")){
			this.password = null;
			this.errmsg = "PASSWORDは「pass」と入力してください";
			return "error";
		}
		//次の画面(Action)で利用できるようにセッションにUserId登録する。
		this.sessionMap.put("userId", this.userId);
		return "main";
	}

}