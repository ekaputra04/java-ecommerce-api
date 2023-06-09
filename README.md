# Java E-Commerce API

<p align = "center">
<img src = "./img/api.jpg" alt="deskripsi_gambar" style="width: 200px; height: 100%; border-radius: 25%; object-fit: cover">
</p>

## Table of Content

- [About](#about)
- [Identitas](#identitas)
- [Folder Structure](#folder)
- [Library and Module](#library) 
- [API Key](#api-key)
- [Spesifikasi API](#spesifikasi) 
    - [GET Method](#get)
    - [POST Method](#post)
    - [PUT Method](#put)
    - [DELETE Method](#delete)
- [Error Condition](#error) 

## About <a name="about"></a>

Java E-commerce API adalah program sederhana yang menyediakan layanan backend untuk aplikasi e-commerce. Program ini memungkinkan aplikasi klien untuk berinteraksi dengan API untuk mengakses dan mengelola data produk, pelanggan, dan pesanan dalam sistem e-commerce.

Program ini dibuat menggunakan Vanilla Java dan bertujuan untuk mengelola data dari database ecommerce melalui penggunaan method GET, POST, PUT, dan DELETE.

Project ini bertujuan untuk memenuhi salah satu tugas dari matakuliah Pemrograman Berbasis Objek - Teknologi Informasi - Universitas Udayana - 2023

## Identitas <a name="identitas"></a>

Nama    : I Putu Eka Putra Juniawan

NIM     : 2205551087

Matkul  : Pemrograman Berbasis Objek (E)

## Folder Structure <a name="folder"></a>

Projek ini terdiri dari beberapa folder sebagai berikut

- `.vscode`: folder untuk menyimpan konfigurasi projek
- `bin`: folder untuk menyimpan file-file biner yang dihasilkan dari proses kompilasi source code Java
- `img`: folder untuk menyimpan gambar-gambar hasil pengujian program
- `lib`: folder untuk menyimpan library
- `Sqlite`: folder untuk menyimpan database
- `src`: folder untuk menyimpan kode program

## Library and Module <a name="library"></a>

`Java E-Commerce API` ini dibangun menggunakan beberapa library modul di antaranya [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind), [json](https://mvnrepository.com/artifact/org.json/json), dan [sqlite](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc).

## API Key <a name="api-key"></a>

Sebelum menggunakan API ini, user harus memasukkan API key dan value yang sesuai dengan data pada file .env seperti berikut.

```
Key : API-KEY

Value : java-ecommerce-api-2205551087
```

User perlu memasukkan key dan value yang benar dalam bagian Authorization

- Apabila key yang dimasukkan salah akan muncul pesan error seperti berikut

<p align = "center">
<img src = "./img/71.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Pesan error ketika memasukkan key yang salah
</p>

- Apabila value yang dimasukkan salah akan muncul pesan error seperti berikut

<p align = "center">
<img src = "./img/72.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Pesan error ketika memasukkan value yang salah
</p>

- Apabila key dan value benar maka akan menjalankan perintah yang diinginkan

<p align = "center">
<img src = "./img/73.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Key dan value benar, maka sistem dapat melakukan apa yang diperintahkan, dalam kasus di atas menampilkan semua daftar users
</p>

## Spesifikasi API <a name="spesifikasi"></a>

API ini dapat menjalankan 4 perintah, di antaranya sabagai berikut:

### GET <a name="get"></a>

Perintah GET bertujuan untuk mengambil data dari tabel, baik semua data maupun data dengan kondisi tertentu

-   **`GET localhost:8087/{table}`**

Path untuk melihat semua data dalam tabel **`table`**

-   **`GET localhost:8087/{table}/{id}`**

Path untuk melihat semua data dalam tabel **`table`** dengan id **`id`**

-   **`GET localhost:8087/{table}?{query}`**

Path untuk melihat semua data dalam tabel **`table`** dengan kondisi pada **`query`**

#### GET table users

-   **`GET localhost:8087/users`**

<p align = "center">
<img src = "./img/4.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan semua data users
</p>

-   **`GET localhost:8087/users/1`**

<p align = "center">
<img src = "./img/5.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan id = 1
</p>

-   **`GET localhost:8087/users/2`**

<p align = "center">
<img src = "./img/6.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan id = 2
</p>

-   **`GET localhost:8087/users/3`**

<p align = "center">
<img src = "./img/7.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan id = 3
</p>

-   **`GET localhost:8087/users?tipe="Buyer"`**

<p align = "center">
<img src = "./img/8.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan tipe buyer
</p>

-   **`GET localhost:8087/users?tipe="Seller"`**

<p align = "center">
<img src = "./img/9.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan tipe seller
</p>

-   **`GET localhost:8087/users?first_name="Emily"`**

<p align = "center">
<img src = "./img/10.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan nama depan Emily
</p>

-   **`GET localhost:8087/users?last_name="Wilson"`**

<p align = "center">
<img src = "./img/11.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan users dengan nama belakang Wilson
</p>

#### GET table addresses

-   **`GET localhost:8087/addresses`**

<p align = "center">
<img src = "./img/12.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan semua data addresses
</p>

-   **`GET localhost:8087/addresses/1`**

<p align = "center">
<img src = "./img/13.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data addresses dengan id = 1
</p>

-   **`GET localhost:8087/addresses/2`**

<p align = "center">
<img src = "./img/14.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data addresses dengan id = 2
</p>

-   **`GET localhost:8087/addresses/9`**

<p align = "center">
<img src = "./img/15.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data addresses dengan id = 9
</p>

-   **`GET localhost:8087/addresses?city="Medan"`**

<p align = "center">
<img src = "./img/16.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data addresses dengan alamat kota Medan
</p>

-   **`GET localhost:8087/addresses?tipe="Kantor"`**

<p align = "center">
<img src = "./img/17.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data addresses dengan tipe kantor
</p>

-   **`GET localhost:8087/addresses?province="Jawa Timur"`**

<p align = "center">
<img src = "./img/18.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data addresses dengan provinsi Jawa Timur
</p>

#### GET table products

-   **`GET localhost:8087/products`**

<p align = "center">
<img src = "./img/19.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan semua data products
</p>

-   **`GET localhost:8087/products/1`**

<p align = "center">
<img src = "./img/20.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data products dengan id = 1
</p>

-   **`GET localhost:8087/products/2`**

<p align = "center">
<img src = "./img/21.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data products dengan id = 2
</p>

-   **`GET localhost:8087/products/3`**

<p align = "center">
<img src = "./img/22.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data products dengan id = 3
</p>

-   **`GET localhost:8087/products?title="Tas Backpack"`**

<p align = "center">
<img src = "./img/23.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data products dengan nama tas backpack
</p>

-   **`GET localhost:8087/products?stock<10`**

<p align = "center">
<img src = "./img/24.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data products dengan stok < 10
</p>

-   **`GET localhost:8087/products?price>750000`**

<p align = "center">
<img src = "./img/25.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data products dengan harga > 750000
</p>

#### GET table orders

-   **`GET localhost:8087/orders`**

<p align = "center">
<img src = "./img/26.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan semua data orders
</p>

-   **`GET localhost:8087/orders/1`**

<p align = "center">
<img src = "./img/27.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data orders dengan id = 1
</p>

-   **`GET localhost:8087/orders/2`**

<p align = "center">
<img src = "./img/28.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data orders dengan id = 2
</p>

-   **`GET localhost:8087/orders/3`**

<p align = "center">
<img src = "./img/29.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data orders dengan id = 3
</p>

-   **`GET localhost:8087/orders?total<200000`**

<p align = "center">
<img src = "./img/30.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data orders dengan total < 200000
</p>

-   **`GET localhost:8087/orders?is_paid=false`**

<p align = "center">
<img src = "./img/31.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data orders dengan status pembayaran false (belum melakukan pembayaran)
</p>

-   **`GET localhost:8087/orders?discount>175000`**

<p align = "center">
<img src = "./img/32.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data orders dengan diskon > 175000
</p>

#### GET table order_details

-   **`GET localhost:8087/order_details`**

<p align = "center">
<img src = "./img/33.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan semua data order detail
</p>

-   **`GET localhost:8087/order_details/1`**

<p align = "center">
<img src = "./img/34.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data order detail dengan id = 1
</p>

-   **`GET localhost:8087/order_details/2`**

<p align = "center">
<img src = "./img/35.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data order detail dengan id = 2
</p>

-   **`GET localhost:8087/order_details/3`**

<p align = "center">
<img src = "./img/36.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data order detail dengan id = 3
</p>

-   **`GET localhost:8087/order_details?quantity=3`**

<p align = "center">
<img src = "./img/37.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data order detail dengan banyak barang = 3
</p>

-   **`GET localhost:8087/order_details?price>265000`**

<p align = "center">
<img src = "./img/38.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data order detail dengan harga > 265000
</p>

-   **`GET localhost:8087/order_details?product=4`**

<p align = "center">
<img src = "./img/39.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data order detail dengan kode produk = 4
</p>

#### GET table reviews

-   **`GET localhost:8087/reviews`**

<p align = "center">
<img src = "./img/40.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan semua data reviews
</p>

-   **`GET localhost:8087/reviews/1`**

<p align = "center">
<img src = "./img/41.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data reviews dengan id = 1
</p>

-   **`GET localhost:8087/reviews/2`**

<p align = "center">
<img src = "./img/42.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data reviews dengan id = 2
</p>

-   **`GET localhost:8087/reviews/3`**

<p align = "center">
<img src = "./img/43.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data reviews dengan id = 3
</p>

-   **`GET localhost:8087/reviews?star=5`**

<p align = "center">
<img src = "./img/44.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data reviews bintang 5
</p>

-   **`GET localhost:8087/reviews?description="Produk tidak sesuai gambar"`**

<p align = "center">
<img src = "./img/45.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Menampilkan data reviews dengan deskripsi tertentu
</p>

### POST <a name="post"></a>

Perintah POST bertujuan untuk menyimpan data ke dalam tabel

-   **`POST localhost:8087/{table}`**

Path untuk method POST untuk memasukkan data dalam tabel **`table`**

#### POST table users

-   **`POST localhost:8087/users`**

<p align = "center">
<img src = "./img/47.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Berhasil menyimpan data ke dalam tabel users, id tidak perlu diinputkan secara manual karena dalam sistem database sudah auto increment
</p>

#### POST table addresses

-   **`POST localhost:8087/addresses`**

<p align = "center">
<img src = "./img/48.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Berhasil menyimpan data ke dalam tabel addresses, id tidak perlu diinputkan secara manual karena dalam sistem database sudah auto increment
</p>

#### POST table products

-   **`POST localhost:8087/products`**

<p align = "center">
<img src = "./img/49.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Berhasil menyimpan data ke dalam tabel products, id tidak perlu diinputkan secara manual karena dalam sistem database sudah auto increment
</p>

#### POST table orders

-   **`POST localhost:8087/orders`**

<p align = "center">
<img src = "./img/50.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Berhasil menyimpan data ke dalam tabel orders, id tidak perlu diinputkan secara manual karena dalam sistem database sudah auto increment
</p>

#### POST table order_details

-   **`POST localhost:8087/order_details`**

<p align = "center">
<img src = "./img/51.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Berhasil menyimpan data ke dalam tabel order_details, id perlu diinputkan secara manual karena dalam sistem database tidak auto increment dikarenakan mengikuti order_id dari tabel orders
</p>

#### POST table reviews

-   **`POST localhost:8087/reviews`**

<p align = "center">
<img src = "./img/52.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Berhasil menyimpan data ke dalam tabel reviews, id tidak perlu diinputkan secara manual karena dalam sistem database sudah auto increment
</p>

### PUT <a name="put"></a>

Perintah PUT bertujuan untuk memodifikasi data dalam tabel

-   **`PUT localhost:8087/{table}/{id}`**

Path untuk method PUT untuk mengupdate data dalam tabel **`table`** dengan id **`id`**

#### PUT table users

-   **`PUT localhost:8087/users/2`**

<p align = "center">
<img src = "./img/53.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Data user dengan id 2 sebelum dilakukan update
</p>

<p align = "center">
<img src = "./img/54.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses update berhasil ditandai dengan munculnya message success
</p>

<p align = "center">
<img src = "./img/55.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Data user dengan id 2 setelah dilakukan update
</p>

#### PUT table addresses

-   **`PUT localhost:8087/addresses/2`**

<p align = "center">
<img src = "./img/56.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses update berhasil ditandai dengan munculnya message success
</p>

#### PUT table products

-   **`PUT localhost:8087/products/2`**

<p align = "center">
<img src = "./img/57.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses update berhasil ditandai dengan munculnya message success
</p>

#### PUT table orders

-   **`PUT localhost:8087/orders/1`**

<p align = "center">
<img src = "./img/58.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses update berhasil ditandai dengan munculnya message success
</p>

#### PUT table order_details

-   **`PUT localhost:8087/order_details/1`**

<p align = "center">
<img src = "./img/59.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses update berhasil ditandai dengan munculnya message success
</p>

#### PUT table reviews

-   **`PUT localhost:8087/reviews/1`**

<p align = "center">
<img src = "./img/60.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses update berhasil ditandai dengan munculnya message success
</p>

### DELETE <a name="delete"></a>

Perintah DELETE bertujuan untuk menghapus data dari tabel

-   **`DELETE localhost:8087/{table}/{id}`**

Path untuk method DELETE untuk menghapus data dalam tabel **`table`** dengan id **`id`**

#### DELETE table users

-   **`DELETE localhost:8087/users/23`**

<p align = "center">
<img src = "./img/61.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses delete users dengan id = 23 berhasil ditandai dengan munculnya message success
</p>

#### DELETE table addresses

-   **`DELETE localhost:8087/addresses/12`**

<p align = "center">
<img src = "./img/62.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses delete addresses dengan id = 12 berhasil ditandai dengan munculnya message success
</p>

#### DELETE table products

-   **`DELETE localhost:8087/products/21`**

<p align = "center">
<img src = "./img/63.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses delete products dengan id = 21 berhasil ditandai dengan munculnya message success
</p>

#### DELETE table orders

-   **`DELETE localhost:8087/orders/11`**

<p align = "center">
<img src = "./img/64.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses delete orders dengan id = 11 berhasil ditandai dengan munculnya message success
</p>

#### DELETE table order_details

-   **`DELETE localhost:8087/order_details/11`**

<p align = "center">
<img src = "./img/65.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses delete order_details dengan id = 11 berhasil ditandai dengan munculnya message success
</p>

#### DELETE table reviews

-   **`DELETE localhost:8087/reviews/11`**

<p align = "center">
<img src = "./img/61.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Proses delete reviews dengan id = 11 berhasil ditandai dengan munculnya message success
</p>

### Error Condition <a name="error"></a>

Jika suatu kondisi yang dilakukan terhadap program tidak terpenuhi, maka akan muncul status code dan message dalam format json seperti berikut

#### Method yang diizinkan hanya GET, POST, PUT, dan DELETE

-   **`PATCH localhost:8087/{table}"`**

<p align = "center">
<img src = "./img/1.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan method PATCH
</p>

-   **`OPTIONS localhost:8087/{table}"`**

<p align = "center">
<img src = "./img/2.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan method OPTIONS
</p>

#### Validasi table name

-   **`METHOD localhost:8087/{invalid-table-name}`**

<p align = "center">
<img src = "./img/3.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan nama tabel yang tidak tersedia
</p>

-   **`POST || PUT localhost:8087/{valid-path} with invalid data`**

    -   Misalkan **`POST localhost:8087/users`**

<p align = "center">
<img src = "./img/67.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika memasukkan data yang tidak valid, dalam kasus di atas tidak kolom tipe tidak dimasukkan
</p>

-   Misalkan **`PUT localhost:8087/users/12`**

<p align = "center">
<img src = "./img/68.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika memasukkan data yang tidak valid, dalam kasus di atas tidak kolom tipe tidak dimasukkan
</p>

-   **` PUT || DELETE localhost:8087/{invalid-path}`**

    -   Misalkan **`PUT localhost:8087/users`**

<p align = "center">
<img src = "./img/69.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan path yang salah pada method PUT, seharusnya /{table-name}/{id}
</p>

-   Misalkan **`DELETE localhost:8087/users`**

<p align = "center">
<img src = "./img/70.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan path yang salah pada method DELETE, seharusnya /{table-name}/{id}
</p>

## Sekian dan Terima Kasih