<?php
/**
 * @version        $Id: ajax_loginsta.php 1 8:38 2010年7月9日Z tianya $
 * @package        DedeCMS.Member
 * @copyright      Copyright (c) 2007 - 2010, DesDev, Inc.
 * @license        http://help.dedecms.com/usersguide/license.html
 * @link           http://www.dedecms.com
 */
require_once(dirname(__FILE__)."/config.php");
AjaxHead();
if($myurl == '') exit('');

$uid  = $cfg_ml->M_LoginID;

!$cfg_ml->fields['face'] && $face = ($cfg_ml->fields['sex'] == '女')? 'dfgirl' : 'dfboy';
$facepic = empty($face)? $cfg_ml->fields['face'] : $GLOBALS['cfg_memberurl'].'/templets/images/'.$face.'.png';
?>
<div class="login_r_link" id="_userlogin">
<div class="login_r_link_t"><h2>用户登录</h2></div>
  <div class="login_r_link_c">
  
  <table border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
      <td height="33">
						<a href="/umanage/"><font color="#FF0000">进入系统后台管理界面</font></a>
			  
     用户：<font color="#000000"><?php echo $cfg_ml->M_UserName; ?></font>
						级别：<font color="#000000">基础代理</font> &nbsp; 
						<a href="<?php echo $cfg_memberurl; ?>"><font color="#000080">管理中心</font></a> &nbsp; 
						<a href="<?php echo $cfg_memberurl; ?>/index_do.php?fmdo=login&dopost=exit"><font color="#f00000">退出</font></a> &nbsp; 
						
				</td>
      <td height="33"><a href="{dede:global.cfg_memberurl/}/index_do.php?fmdo=user&dopost=regnew">注册用户</a>&nbsp;&nbsp;&nbsp;<font class="gray_font">|</font>&nbsp;&nbsp;&nbsp;<a href="{dede:global.cfg_memberurl/}/resetpassword.php">取回密码</a>&nbsp;&nbsp;&nbsp;<font class="gray_font">|</font>&nbsp;&nbsp;&nbsp;<a href="/help/">帮助中心</a></td>
    </tr>
    </tbody></table>
	
	
  </div>
<div class="login_r_link_r"></div>
</div>