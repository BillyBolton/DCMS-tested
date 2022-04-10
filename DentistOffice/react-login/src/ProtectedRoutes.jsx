import {Naviagte, Outlet} from 'react-router';
//import {loggedIn} from './App';

const useAuth = () => {
    const user = {loggedIn: false};
    return user && user.loggedIn;
};

const ProtectedRoutes = () => {
    const isAuth = useAuth();
    return isAuth ? <Outlet /> : <Naviagte to="/" />;
}

export default ProtectedRoutes;