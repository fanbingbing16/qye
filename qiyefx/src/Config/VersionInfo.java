/**
 * 
 */
package Config;

/**
 * @author joeyang ong
 *
 */
public class VersionInfo {
	
    //application info
	public final static String APP_NAME="ABC购物系统";
    public final static String APP_VERSION="2.0";
    public final static String APP_STATUS="Beta";
    public final static String APP_BUILDATE="2021-6-28";
    public final static String APP_BUILDVER="#1";
    	
    //application author
    public final static String APP_AUTHOR="福理43号张烟铃";
    public final static String APP_WORKSTUDIO="张烟铃";
    
    public final static String buildFooterStr()
    {
    	StringBuffer sb=new StringBuffer();

    	sb.append(APP_NAME);
    	sb.append(" "+"(版本:"+APP_STATUS+APP_VERSION);
    	sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
    	sb.append(" "+APP_BUILDATE+")");
    	sb.append("&nbsp;&nbsp;&nbsp;&nbsp;开发团队:&nbsp;<a href=\"mailto:j@yahoo.com.cn\">"+APP_AUTHOR+"</a><br/>");
    	sb.append("&copy;&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");

    	return sb.toString();	
    }

}
