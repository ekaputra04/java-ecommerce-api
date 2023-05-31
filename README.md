# Java E-Commerce API

<p align = "center">
<img src = "./img/api.jpg" alt="deskripsi_gambar" style="width: 200px; height: 100%; border-radius: 25%; object-fit: cover">
</p>

## Table of Content

- [About](#about)
- [Identitas](#identitas)
- [Folder Structure](#folder)
- [Library and Module](#library) 
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

`Java E-Commerce API` ini dibangun menggunakan beberapa library modul di antaranya [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind), [json](https://mvnrepository.com/artifact/org.json/json), dan [sqlite](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc), 

## Spesifikasi API <a name="spesifikasi"></a>

API ini dapat menjalankan 4 perintah, di antaranya:

### GET <a name="get"></a>

Perintah GET bertujuan untuk mengambil data dari tabel, baik semua data maupun data dengan kondisi tertentu

-   **`GET localhost:8087/{table}`**

Path untuk GET melihat semua data dalam tabel **`table`**

-   **`GET localhost:8087/{table}/{id}`**

Path untuk GET melihat semua data dalam tabel **`table`** dengan id **`id`**

-   **`GET localhost:8087/{table}?{query}`**

Path untuk GET melihat semua data dalam tabel **`table`** dengan kondisi pada **`query`**

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

Perintah DELETE bertujuan untuk menghapus data dari tabel, baik semua data maupun data dengan kondisi tertentu

#### DELETE table users



#### DELETE table addresses

#### DELETE table products

#### DELETE table orders

#### DELETE table order_details

#### DELETE table reviews

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

-   **`GET localhost:8087/{invalid-table-name}`**

<p align = "center">
<img src = "./img/3.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan nama tabel yang tidak tersedia
</p>

-   **`POST || PUT || DELETE localhost:8087/{invalid-path}`**

    -   Misalkan **`POST localhost:8087/user`**

<p align = "center">
<img src = "./img/46.png" alt="deskripsi_gambar" style="width: 500px; height: auto">
</br>
Error message ketika menggunakan nama tabel yang tidak valid
</p>