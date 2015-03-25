package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fw.DBManager;
import fw.ResultSetBeanMapping;

public class WikiPageDAO {

	/**
	 * ResultSet��1�s��WikiPage�̃C���X�^���X�ɕϊ�����N���X
	 * �����ł������p����Ȃ��̂ŁA
	 * �����N���X�Ƃ��āA���̏ꏊ�ŃC���X�^���X�����܂��B
	 */
	private ResultSetBeanMapping<WikiPage> allMapping = new ResultSetBeanMapping<WikiPage>() {

		public WikiPage createFromResultSet(ResultSet rs) throws SQLException{

			WikiPage page = new WikiPage();
			page.setName(rs.getString("name"));
			page.setContent(rs.getString("content"));
			page.setUpdateTime(rs.getTimestamp("update_time"));
			return page;
		}
	};

	/**
	 * ���̃N���X�̃C���X�^���X���擾���܂�
	 */
	public static WikiPageDAO getInstance(){
		return new WikiPageDAO();
	}

	/**
	 * �S���������s���܂��B
	 * �߂�l��WikiPage�I�u�W�F�N�g��List
	 */
	public List<WikiPage> findAll() throws SQLException{
		String sql = "SELECT * FROM wiki_page" + " ORDER BY update_time DESC";

		return DBManager.simpleFind(sql, allMapping);
	}

	/**
	 * �w�肵�����O�Ɉ�v���郌�R�[�h���������܂��B
	 */
	public WikiPage findByName(String name) throws SQLException{
		String sql = "SELECT * FROM wiki_page" + " WHERE name='" + name + "'";

		List<WikiPage> list = DBManager.simpleFind(sql, allMapping);
		if(list.size() == 0){
			return null;
		}
		else if(list.size() > 1){
			throw new IllegalArgumentException(" record > 1 ");
		}

		return list.get(0);
	}

	/**
	 * �w�肵��WikiPage������INSERT�����s���܂��B
	 */
	public void insert(WikiPage page) throws SQLException {
		String sql = "INSERT INTO wiki_page (name, content)"
				+ " VALUES("
				+ "'" + page.getName() + "'"
				+ ",'" + page.getContent() + "'"
				+")";
		DBManager.simpleUpdate(sql);
	}

	/**
	 * �w�肵��WikiPage������UPDATE�����s���܂��B
	 */
	public void update(WikiPage page) throws SQLException{
		String sql = "UPDATE wiki_page"
				+ " SET "
				+ " content='" + page.getContent() + "'"
				+ " WHERE name='" + page.getName() + "'";

		DBManager.simpleUpdate(sql);
	}

	/**
	 * �w�肵��WikiPage������DELETE�����s���܂�
	 */
	public void delete(WikiPage page) throws SQLException{
		String sql = "DELETE FROM wiki_page WHERE name='"
				+ page.getName() + "'";
		DBManager.simpleUpdate(sql);
	}

}
