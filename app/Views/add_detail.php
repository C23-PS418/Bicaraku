<!DOCTYPE html>
<html>

<head>
	<title>Tambah Buku</title>
</head>

<body>

	<form action="<?= site_url('addData/savedetail') ?>" method="post">
		<?= csrf_field() ?>

		<div>
			<label for="idhuruf">Huruf:</label>
			<select name="idhuruf" id="idhuruf">
				<?php foreach ($huruf as $h) : ?>
					<option value="<?= $h['idhuruf'] ?>" name="idhuruf"><?= $h['teks'] ?></option>
				<?php endforeach; ?>
			</select>
		</div>

		<div>
			<label for="urlbuku1">URL Buku 1:</label>
			<input type="text" name="gambar[]" id="urlbuku1">
		</div>

		<div>
			<label for="urlbuku2">URL Buku 2:</label>
			<input type="text" name="gambar[]" id="urlbuku2">
		</div>

		<div>
			<label for="urlbuku3">URL Buku 3:</label>
			<input type="text" name="gambar[]" id="urlbuku3">
		</div>

		<button type="submit">Tambah Buku</button>
	</form>
</body>

</html>
