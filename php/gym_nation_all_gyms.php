<?php 
	
	require_once('gym_nation_database_conn_link.php');
	
	//database constants
	define('DB_HOST', $db_server );
	define('DB_USER', $DB_USER);
	define('DB_PASS', $DB_PASS);
	define('DB_NAME', "Gym_Nation_Gyms_Database");
        
       
	
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
	$stmt = $conn->prepare("SELECT _id, gym_name, gym_logo,gym_database_url FROM all_gym_nation_gyms;");
	
	//executing the query 
	$stmt->execute();
	
	//binding results to the query 
	$stmt->bind_result($_id, $gym_name, $gym_logo,$gym_database_url);
	
	$gyms = array(); 
	
	//traversing through all the result 
	while($stmt->fetch()){
		$temp = array();
		$temp['_id'] = $_id; 
	        $temp['gym_name'] = $gym_name;      
                $temp['gym_logo'] = $gym_logo; 
                $temp['gym_database_url'] = $gym_database_url;      
                

		array_push($gyms, $temp);
	}
	
	//displaying the result in json format 
	echo json_encode($gyms,JSON_UNESCAPED_UNICODE);
        
       
        
	
	 
