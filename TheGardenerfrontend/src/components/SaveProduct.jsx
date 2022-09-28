// import { useDispatch, useSelector } from 'react-redux';
// import axios from "axios";
// import { useEffect, useState } from "react";
// import { useHistory } from "react-router-dom";
// import productvalidation from "./productvalidation";

// function SaveProduct() {
//   const sellerid = sessionStorage.getItem("id");
//   const [product, setProduct] = useState({
//     pname: "",
//     pcat: "",
//     price: "",
//     // subcat: "",
//     // brand: "",
//     sellerId: sellerid,
//   });
//   const [errors, setErrors] = useState({});
//   const [loadingUpload, setLoadingUpload] = useState(false);
//   const [selectedPhoto, setSelectedPhoto] = useState(null);
//   const [submitted, setSubmitted] = useState(false);
//   const [errorUpload, setErrorUpload] = useState('');
//   const history = useHistory();

//   const handleInput = (e) => {
//     setProduct({ ...product, [e.target.name]: e.target.value });
//   };

// //   const handleFileInput = (e) => {
// //     setSelectedPhoto(e.target.files[0]);
// //   };

// const handleFileInput = async (e) => {
//     const file = e.target.files[0];
//     const bodyFormData = new FormData();
//      bodyFormData.append('file', file);
//    // bodyFormData.append('imageFile',imageFile)
//     bodyFormData.append('fileName',file.name);
//     setLoadingUpload(true);
//     try {
//       const { data } = await axios.post(`http://localhost:8080/api/products/${prodid}/image`, bodyFormData, {
//         headers: {
//           'Content-Type': 'multipart/form-data',
//         },
//       });
//       setSelectedPhoto(data);
//       setLoadingUpload(false);
//     } catch (error) {
//       setErrorUpload(error.message);
//       setLoadingUpload(false);
//     }
//   };




//   const handleSubmit = async (e) => {
//     e.preventDefault();
// try{
// const { data } = await axios.put('http://localhost:8080/api/products/save', product, {
     
//     });
// }
//     catch (error) {
//     console.log(error);
// };

//     setErrors(productvalidation(product));
//     setSubmitted(true);
//   };


//  return (
//     <div className="container">
//       <div className="card shadow bg-dark text-white">
//         <div className="card-body">
//           <div className="row">
//             <div className="col-sm-6 mx-auto">
//               <h4 className="text-center p-2">Add Product Form</h4>
//               <form onSubmit={handleSubmit}>
//                 <div className="form-group form-row">
//                   <label className="col-sm-4 form-control-label">
//                     Product Name
//                   </label>
//                   <div className="col-sm-8">
//                     <input
//                       type="text"
//                       name="pname"
//                       value={product.pname}
//                       onChange={handleInput}
//                       className="form-control"
//                     />
//                     {errors.pname && (
//                       <small className="text-danger float-right">
//                         {errors.pname}
//                       </small>
//                     )}
//                   </div>
//                 </div>
//                 <div className="form-group form-row">
//                   <label className="col-sm-4 form-control-label">
//                     Category
//                   </label>
//                   <div className="col-sm-8">
//                     <select
//                       name="pcat"
//                       value={product.pcat}
//                       onChange={handleInput}
//                       className="form-control"
//                     >
//                       <option value="">Select Category</option>
//                       <option>Seeds</option>
//                       <option>Pesticides & Fertilizers</option>
//                       <option>Gardening Tools</option>
//                       <option>Plants</option>
//                       <option>Planters</option>
//                     </select>
//                     {errors.pcat && (
//                       <small className="text-danger float-right">
//                         {errors.pcat}
//                       </small>
//                     )}
//                   </div>
//                 </div>
                
//                 <div className="form-group form-row ">
//                   <label className="col-sm-4 form-control-label ">Price</label>
//                   <div className="col-sm-8 ">
//                     <input
//                       type="number"
//                       name="price"
//                       value={product.price}
//                       onChange={handleInput}
//                       className="form-control"
//                     />
//                     {errors.price && (
//                       <small className="text-danger float-right">
//                         {errors.price}
//                       </small>
//                     )}
//                   </div>
//                 </div>
                

//                 <div className="form-group form-row">
//                   <label className="col-sm-4 form-control-label">Photo</label>
//                   <div className="col-sm-8">
//                     <input
//                       type="file"
//                       required
//                       name="photo"
//                       value={product.photo}
//                       onChange={handleFileInput}
//                       className="form-control-file"
//                     />
//                   </div>
//                 </div>

//                 <button className="btn btn-primary float-right">
//                   Add Product
//                 </button>
//               </form>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default SaveProduct;


  