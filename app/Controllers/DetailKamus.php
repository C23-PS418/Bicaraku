<?php

namespace App\Controllers;

use CodeIgniter\RESTful\ResourceController;
use App\Models\Detailhuruf;
class DetailKamus extends ResourceController
{
    /**
     * Return an array of resource objects, themselves in array format
     *
     * @return mixed
     */
    public function index()
    {
		$request = \Config\Services::request();
		$model = new Detailhuruf();
		
		$idhuruf = $request->getVar('idhuruf');
		$data = $model->where('idhuruf', $idhuruf)->findAll();
		$response = [
			'status' => 200,
			'error' => "false",
			'message' => '',
			'totaldata' => count($data),
			'data' => $data,
		];
		return $this->respond($response, 200);
    }

    /**
     * Return the properties of a resource object
     *
     * @return mixed
     */
    public function show($id = null)
    {
        //
    }

    /**
     * Return a new resource object, with default properties
     *
     * @return mixed
     */
    public function new()
    {
        //
    }

    /**
     * Create a new resource object, from "posted" parameters
     *
     * @return mixed
     */
    public function create()
    {
        //
    }

    /**
     * Return the editable properties of a resource object
     *
     * @return mixed
     */
    public function edit($id = null)
    {
        //
    }

    /**
     * Add or update a model resource, from "posted" properties
     *
     * @return mixed
     */
    public function update($id = null)
    {
        //
    }

    /**
     * Delete the designated resource object from the model
     *
     * @return mixed
     */
    public function delete($id = null)
    {
        //
    }
}
