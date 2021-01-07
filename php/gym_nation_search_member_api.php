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
        
        

	//$rfiddd=$_POST['searchQuery'];
     //   $rfiddd='2D D9 77 89';
        
        
       $rfiddd = isset($_POST['rfid']) ? $_POST['rfid'] : '';
       if (isset($_POST['rfid'])) {   
        
        
	//creating a query
	$stmt = $conn->prepare("SELECT * FROM member_data WHERE RFID = '$rfiddd'");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($_id,$full_name,$phone_number,$registration_date,$start_date,$end_date,$plane,$gender,$weight_kg,$height_cm,$birthdate,$address,$hint,$img_title,$image,$RFID);
        
	$adpost = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		
                
                
                $temp['_id'] = $_id;
		$temp['full_name'] = $full_name; 
                $temp['phone_number'] = $phone_number;
                $temp['start_date'] = $start_date;
                $temp['end_date'] = $end_date;
                $temp['plane'] = $plane;
                $temp['gender'] = $gender;
                $temp['weight_kg'] = $weight_kg;
                $temp['height_cm'] = $height_cm;
                $temp['birthdate'] = $birthdate;
                $temp['address'] = $address;
                $temp['hint'] = $hint;
                $temp['img_title'] = $img_title;
                $temp['image'] = $image;
                $temp['RFID'] = $RFID;
                
                

		array_push($adpost, $temp);
	}
        	
	//displaying the result in json format 
	echo json_encode($adpost,JSON_UNESCAPED_UNICODE);

        }
        else { echo "no rows";}
        