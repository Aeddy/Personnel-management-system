package  com.neusoft.dao.provider;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.neusoft.pojo.User;
import  static com.neusoft.util.common.HrmConstants.USERTABLE;

public class UserDynaSqlProvider {
	
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUser_loginname() != null && !user.getUser_loginname().equals("")){
						WHERE("  user_loginname LIKE CONCAT ('%',#{user.user_loginname},'%') ");
					}
					if(user.getUser_status() != null && !user.getUser_status().equals("")){
						WHERE(" user_status LIKE CONCAT ('%',#{user.user_status},'%') ");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUser_loginname() != null && !user.getUser_loginname().equals("")){
						WHERE(" user_loginname LIKE CONCAT ('%',#{user.user_loginname},'%') ");
					}
					if(user.getUser_status() != null && !user.getUser_status().equals("")){
						WHERE(" user_status LIKE CONCAT ('%',#{user.user_status},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	
	public String insertuser(User user){
		
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUser_loginname() != null && !user.getUser_loginname().equals("")){
					VALUES("user_loginname", "#{user_loginname}");
				}
				if(user.getUser_status() != null && !user.getUser_status().equals("")){
					VALUES("user_status", "#{user_status}");
				}
				if(user.getUser_name() != null && !user.getUser_name().equals("")){
					VALUES("user_name", "#{user_name}");
				}
				if(user.getUser_password() != null && !user.getUser_password().equals("")){
					VALUES("user_password", "#{user_password}");
				}
			}
		}.toString();
	}
	
	public String zhuceuser(User user)
	{
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUser_name()!=null&&!user.getUser_name().equals(""))
				{
					VALUES("user_name","#{user_name}");
				}
				if(user.getUser_loginname()!=null&&!user.getUser_loginname().equals(""))
				{
					VALUES("user_loginname","#{user_loginname}");
				
				}
				if(user.getUser_password()!=null&&!user.getUser_password().equals(""))
				{
					VALUES("user_password","#{user_password}");
				}
			}
			
		}.toString();
	}
	
	
		public String updateuser(User user){
			
			return new SQL(){
				{
					UPDATE(USERTABLE);
					if(user.getUser_name() != null){
						SET(" user_name = #{user_name} ");
					}
					if(user.getUser_loginname() != null){
						SET(" user_loginname = #{user_loginname} ");
					}
					if(user.getUser_password()!= null){
						SET(" user_password = #{user_password} ");
					}
					if(user.getUser_status()!= null){
						SET(" user_status = #{user_status} ");
					}
					if(user.getUser_createdate()!= null){
						SET(" user_createdate = #{user_createdate} ");
					}
					WHERE(" user_id = #{user_id} ");
				}
			}.toString();
		}
}
