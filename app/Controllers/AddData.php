<?php

namespace App\Controllers;

use App\Controllers\BaseController;
use App\Models\Detailhuruf;
use App\Models\Huruf;

class AddData extends BaseController
{
	public function index()
	{
		return view('index');
	}

	public function save()
	{
		$huruf = $this->request->getPost('huruf');
		$gambar = $this->request->getPost('gambar');

		$hurufModel = new Huruf();
		$data = [
			'teks' => $huruf,
			'gambar' => $gambar
		];
		$hurufModel->insert($data);
		return view('index');
	}

	public function detail()
	{
		$hurufModel = new Huruf();
		$data['huruf'] = $hurufModel->findAll();

		return view('add_detail', $data);
	}

	public function savedetail()
	{
		$detailhurufModel = new Detailhuruf();
		$idhuruf = $this->request->getPost('idhuruf');
		$gambar = $this->request->getPost('gambar');
		$batchData = [];
		foreach ($gambar as $gambar) {
			$batchData[] = [
				'idhuruf' => $idhuruf,
				'gambar' => $gambar,

			];
		}
		$detailhurufModel->insertBatch($batchData);
		return redirect()->back()->with('success', 'Buku berhasil ditambahkan.');
	}
}
