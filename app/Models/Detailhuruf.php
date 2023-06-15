<?php

namespace App\Models;

use CodeIgniter\Model;

class Detailhuruf extends Model
{
    protected $DBGroup          = 'default';
    protected $table            = 'detailhuruf';
    protected $primaryKey       = 'id';
    protected $allowedFields    = ['idhuruf','gambar'];

	public function cekId($idhuruf)
	{
		// Use the $idhuruf parameter to query the data from the model
		// Modify the code below based on your actual database structure and queries
		$query = $this->select('*')->where('idhuruf', $idhuruf)->get();

		if ($query->getNumRows() > 0) {
			// If data is found, return the results as an array
			return $query->getResultArray();
		} else {
			// If no data is found, return an empty array or handle the error accordingly
			return [];
		}
	}
}
