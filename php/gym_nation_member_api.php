<?php 
	$gymname = isset($_POST['gymname']) ? $_POST['gymname'] : '';
       if (isset($_POST['gymname'])) {   
	
	require_once('gym_nation_database_conn_link.php');
	
	//database constants
	define('DB_HOST', $db_server );
	define('DB_USER', $DB_USER);
	define('DB_PASS', $DB_PASS);
	define('DB_NAME', $gymname);
        
       }
	
	//connecting to database and getting the connection object
	$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	
	//Checking if any error occured while connecting
	if (mysqli_connect_errno()) {
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
		die();
	}
        
         header('Contrnt-Type: app;ication/Json; charset=utf-8');
        mysqli_set_charset($conn,"utf8");
	
	//creating a query
	$stmt = $conn->prepare("SELECT _id, member_name, member_photo, member_start_date, member_end_date, plane ,workout_one_name,workout_two_name,enter_member_time_date FROM members_at_the_gym;");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($_id, $member_name, $member_photo, $member_start_date, $member_end_date, $plane,$workout_one_name,$workout_two_name,$enter_member_time_date);
	
	$members_at_the_gym = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['_id'] = $_id; 
		$temp['member_name'] = $member_name; 
	        $temp['member_photo'] = $member_photo; 
		$temp['member_start_date'] = $member_start_date; 
		$temp['member_end_date'] = $member_end_date; 
		$temp['plane'] = $plane; 
                $temp['workout_one_name'] = $workout_one_name; 
            //  $temp['workout_one_img'] = $workout_one_img; 
                $temp['workout_two_name'] = $workout_two_name; 
            //  $temp['workout_two_img'] = $workout_two_img; 
                $temp['enter_member_time_date'] = $enter_member_time_date; 
               
                

		array_push($members_at_the_gym, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($members_at_the_gym,JSON_UNESCAPED_UNICODE);
       
        
	
	