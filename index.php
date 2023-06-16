<?php
$servername = "";
$database = "";
$username = "";
$password = "";

// membuat koneksi
$conn = mysqli_connect($servername, $username, $password, $database);

// mengecek koneksi
if (!$conn) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

if ($_SERVER["REQUEST_METHOD"] === "GET") {
    // Mengambil nilai yang dikirim melalui GET
    $input = $_GET["input_data"];
	

    // Melakukan sanitasi pada input untuk menghindari serangan SQL Injection
    $input = mysqli_real_escape_string($conn, $input);
	
	if ($input === "*") {
        // Jika input adalah "*", tampilkan semua data
        $query = "SELECT * FROM huruf";
    } else {
        // Jika input adalah huruf tertentu, tampilkan data berdasarkan huruf
        $query = "SELECT b.gambar FROM huruf a JOIN detailhuruf b ON a.idhuruf=b.idhuruf WHERE a.teks='$input'";
    }
	
	$result = mysqli_query($conn, $query);


    

   // Mengecek apakah terdapat data yang sesuai
    if (mysqli_num_rows($result) > 0) {
        // Menginisialisasi array untuk menampung data huruf
        $data_huruf = array();

        // Mengambil dan menambahkan setiap baris data ke array
        while ($row = mysqli_fetch_assoc($result)) {
            $data_huruf[] = $row;
        }

        // Mengonversi array menjadi format JSON
        $json_data = json_encode($data_huruf);

        // Menghapus karakter escape dari string JSON
        $json_data = stripslashes($json_data);

        // Menampilkan data JSON
        echo $json_data;
    } else {
        echo "Data tidak ditemukan.";
    }
}

// Menutup koneksi
mysqli_close($conn);
?> 	
