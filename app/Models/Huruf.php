<?php

namespace App\Models;

use CodeIgniter\Model;

class Huruf extends Model
{
    protected $DBGroup          = 'default';
    protected $table            = 'huruf';
    protected $primaryKey       = 'id';
    protected $allowedFields    = ['teks','gambar'];

}
