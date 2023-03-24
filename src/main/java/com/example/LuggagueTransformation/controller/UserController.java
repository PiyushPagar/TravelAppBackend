package com.example.LuggagueTransformation.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.LuggagueTransformation.Repo.DriverDetailsRepository;
import com.example.LuggagueTransformation.Repo.RoleRepository;
import com.example.LuggagueTransformation.Repo.UserRepository;
import com.example.LuggagueTransformation.dto.LoginRequest;
import com.example.LuggagueTransformation.dto.MessageResponse;
import com.example.LuggagueTransformation.dto.SignupDriverRequest;
import com.example.LuggagueTransformation.dto.SignupRequest;
import com.example.LuggagueTransformation.dto.StatusMessageResponseDto;
import com.example.LuggagueTransformation.dto.UpdateUser;
import com.example.LuggagueTransformation.dto.UserInfoResponse;
import com.example.LuggagueTransformation.models.DriverDetails;
import com.example.LuggagueTransformation.models.ERole;
import com.example.LuggagueTransformation.models.FileDetails;
import com.example.LuggagueTransformation.models.Role;
import com.example.LuggagueTransformation.models.User;
import com.example.LuggagueTransformation.security.jwt.JwtUtils;
import com.example.LuggagueTransformation.service.UserDetailsImpl;
import com.example.LuggagueTransformation.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	DriverDetailsRepository driverDetailsRepository;
//	@Autowired
//	private EmailSenderService emailSenderService;
	@Autowired
	private UserService userService;
	@Value("${project.image}")
	private String path;

//	@Autowired
//	UserRequestForOTPdto userRequestForOTPdto;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		String role = roles.get(0);
		String jwtTokenValue = jwtCookie.getValue();
		UserInfoResponse result = new UserInfoResponse(userDetails.getId(), userDetails.getUsername(),
				userDetails.getName(), role, jwtTokenValue, userDetails.getMobileNo(), false);
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
				.body(new MessageResponse("User Login Sucess", HttpStatus.OK.value(), result));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerClientUser(@Valid @RequestBody SignupRequest signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(
					new StatusMessageResponseDto(HttpStatus.BAD_REQUEST.value(), "Error: Email is already in use!"));
		}
		User user = new User(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getName(), signUpRequest.getMobileNo());
		Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_USER);
		user.setRole(userRole.get());
		userRepository.save(user);
		return ResponseEntity.ok(new StatusMessageResponseDto(HttpStatus.OK.value(), "User registered successfully!"));
	}
	
	
	
	
	@PostMapping(value="/driversignup")
	public ResponseEntity<?> registerDriverUser(@Valid @RequestBody SignupDriverRequest signUpDriverRequest) throws IOException {
		try {		
			if (userRepository.existsByEmail(signUpDriverRequest.getEmail())) {
				return ResponseEntity.badRequest().body(new StatusMessageResponseDto(HttpStatus.BAD_REQUEST.value(),
						"Error: Email is already in use!"));
			}
			User user = new User(signUpDriverRequest.getEmail(), encoder.encode(signUpDriverRequest.getPassword()),
					signUpDriverRequest.getName(), signUpDriverRequest.getMobileNo());
			Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_DRIVER);
			user.setRole(userRole.get());
			Long userid = userRepository.save(user).getId();
			DriverDetails driverDetails = new DriverDetails();
			driverDetails.setUserId(userid);
			driverDetails.setLiencesUrl("/liences/details.png");
			driverDetails.setLiencesName("details.png");
			driverDetails.setVehicalName(signUpDriverRequest.getVehicalName());
			driverDetails.setVehicalNo(signUpDriverRequest.getVehicalNo());
			driverDetailsRepository.save(driverDetails);
			return ResponseEntity
					.ok(new StatusMessageResponseDto(HttpStatus.OK.value(), "Driver registered successfully!"));
		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity.ok(new StatusMessageResponseDto(HttpStatus.FAILED_DEPENDENCY.value(), "Not Register!"));
		}
		return ResponseEntity
				.ok(new StatusMessageResponseDto(HttpStatus.OK.value(), "Driver registered successfully!"));
	}

//	@PostMapping(value="/driversignup", consumes = {"multipart/mixed"})
//	public ResponseEntity<?> registerDriverUser(@Valid @RequestBody SignupDriverRequest signUpDriverRequest,
//			@RequestParam("file") MultipartFile file) throws IOException {
//		String fileName = uploadImage(path,file);
//		String filePathStr="C://lugguges" + fileName;
//		try {		
//			if (userRepository.existsByEmail(signUpDriverRequest.getEmail())) {
//				return ResponseEntity.badRequest().body(new StatusMessageResponseDto(HttpStatus.BAD_REQUEST.value(),
//						"Error: Email is already in use!"));
//			}
//			User user = new User(signUpDriverRequest.getEmail(), encoder.encode(signUpDriverRequest.getPassword()),
//					signUpDriverRequest.getName(), signUpDriverRequest.getMobileNo());
//			Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_USER);
//			user.setRole(userRole.get());
//			Long id = userRepository.save(user).getId();
//			DriverDetails driverDetails = new DriverDetails(id, fileName, filePathStr);
//			driverDetailsRepository.save(driverDetails);
//			return ResponseEntity
//					.ok(new StatusMessageResponseDto(HttpStatus.OK.value(), "Driver registered successfully!"));
//		} catch (Exception e) {
//			e.printStackTrace();
//			ResponseEntity.ok(new StatusMessageResponseDto(HttpStatus.FAILED_DEPENDENCY.value(), "Not Register!"));
//		}
//		return ResponseEntity
//				.ok(new StatusMessageResponseDto(HttpStatus.OK.value(), "Driver registered successfully!"));
//	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new StatusMessageResponseDto(HttpStatus.OK.value(), "You've been signed out!"));
	}

	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateuser(@PathVariable("id") long id, @RequestBody UpdateUser user) {
		User Existinguser = userRepository.findUserById(id);
		Existinguser.setEmail(user.getEmail());
		Existinguser.setName(user.getName());
		Existinguser.setMobileNo(user.getMobileNo());
		return new ResponseEntity<User>(userRepository.save(Existinguser), HttpStatus.OK);
	}

	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getCategorybyId(@PathVariable("id") long userId) {
		return new ResponseEntity<User>(userRepository.findUserById(userId), HttpStatus.OK);
	}
	
	
	
	
	
	public String uploadImage(String path, MultipartFile multipartFile) throws IOException {
		String name = multipartFile.getOriginalFilename();
		String randomID= UUID.randomUUID().toString();
		String filename= randomID.concat(name.substring(name.lastIndexOf(".")));
		String filepath = path + File.separator+ filename;
		File f= new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		Files.copy(multipartFile.getInputStream(), Paths.get(filepath), StandardCopyOption.REPLACE_EXISTING);
		return filename;
	}

}
