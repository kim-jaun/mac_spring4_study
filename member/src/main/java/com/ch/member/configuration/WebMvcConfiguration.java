package com.ch.member.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.ch.member.service.SessionChk;
@Configuration
public class WebMvcConfiguration  implements WebMvcConfigurer{
	@Bean  // fileUpload
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("utf-8");
		cmr.setMaxUploadSizePerFile(10*1024*1024); // 파일크기 10M
		return cmr;
	}
	// sessionCheck
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionChk())
			.excludePathPatterns("/**/joinForm.do","/**/join.do","/**/idChk.do",
					"/**/loginForm.do","/**/login.do","/**/joinForm2.do",
					"/**/join2.do")
			.addPathPatterns("/**/*.do");
		// .addPathPatterns("/**/main.do","/**/updateForm.do","/**/update.do","/**/delete.do","/**/view.do","/**/view2.do")
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}