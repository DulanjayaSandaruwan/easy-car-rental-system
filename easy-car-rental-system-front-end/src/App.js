import './App.css';
import HeaderComponent from './components/adminComponents/header/HeaderComponent';
import {BrowserRouter} from "react-router-dom";

function App() {
    return (
        <BrowserRouter>
            <HeaderComponent/>
        </BrowserRouter>

    );
}

export default App;
