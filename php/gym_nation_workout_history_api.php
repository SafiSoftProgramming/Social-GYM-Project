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
        
        
      
       $rfiddd = isset($_POST['rfid']) ? $_POST['rfid'] : '';
       if (isset($_POST['rfid'])) {   
        
     
	//creating a query
	$stmt = $conn->prepare("SELECT * FROM members_workout_history WHERE rfid ='$rfiddd'");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($_id,$member_name,$member_photo,$workout_one_name,$workout_two_name,$start_workout_date,$start_workout_time,$end_workout_time,$workout_time_duration,$workout_rate,$workout_sign_out_mode,$rfid);
        
	$workout = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		
                
                
                $temp['_id'] = $_id;
		$temp['member_name'] = $member_name; 
                $temp['member_photo'] = $member_photo;
                $temp['workout_one_name'] = $workout_one_name;
                $temp['workout_two_name'] = $workout_two_name;
                $temp['start_workout_date'] = $start_workout_date;
                $temp['start_workout_time'] = $start_workout_time;
                $temp['end_workout_time'] = $end_workout_time;
                $temp['workout_time_duration'] = $workout_time_duration;
                $temp['workout_rate'] = $workout_rate;
                $temp['workout_sign_out_mode'] = $workout_sign_out_mode;
                $temp['rfid'] = $rfid;
               
                
                

		array_push($workout, $temp);
	}
        	
	//displaying the result in json format 
	echo json_encode($workout,JSON_UNESCAPED_UNICODE);
        
        
          }
        else { echo "no rows";}
        

        
       
        