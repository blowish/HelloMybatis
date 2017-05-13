package model.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class AbstractDAO {

	protected static SqlSession sqlSession = null;

	/*
	 * このクラスのコンストラクタ
	 */
	public AbstractDAO() throws IOException {
		if (sqlSession == null) {
			initialize();
		}
	}

	/*
	 * mybatis-blowish-config.xmlに記載したルールでデータベースにアクセスする
	 */
	public void initialize() throws IOException {

		InputStream inputStream = this.getClass().getResourceAsStream("/resources/mybatis-blowish-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = factory.openSession();
		System.out.println("MySQL 接続完了！");
	}
}