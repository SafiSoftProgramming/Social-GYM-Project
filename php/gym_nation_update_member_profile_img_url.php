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
        
        
        
       $img_new_url = isset($_POST['profile_img_new_url']) ? $_POST['profile_img_new_url'] : '';
    
        
        
        
       $rfiddd = isset($_POST['rfid']) ? $_POST['rfid'] : '';
       if (isset($_POST['rfid'])) {   
        
                  
       $sql = "UPDATE member_data SET image='$img_new_url' WHERE RFID = '$rfiddd'";
       
       }
       
       if (mysqli_query($conn, $sql)) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . mysqli_error($conn);
}

mysqli_close($conn);
?>

      