import {Route, Routes} from "react-router-dom";
import Receptionist from "./components/Receptionist";
import Doctor from "./components/Doctor";
import ProtectedRoutes from "./ProtectedRoutes";


const Views = () => {
    return (
       <Routes>
           <Route path="/" element={<LoginForm />}></Route>
           <Route element={<ProtectedRoutes />}>
            <Route path="/receptionist" element={<Receptionist />}>Receptionist</Route>
           </Route>
           
       </Routes> 
    )
}

export default Views;