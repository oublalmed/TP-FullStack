import { Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';


function Navigationbar() {
  return (
    <Navbar bg="dark" variant="dark" className="justify-content-center">

      <Link
        to={'add'} 
        className="nav-link"
        style={{ margin: '20px', color: 'white' }}
      >
        Ajouter un Module
      </Link>
      <Link to={'list'} className="nav-link" style={{ color: 'white' }}>
        Liste des Modules
      </Link>
      
    </Navbar>
  );
}

export default Navigationbar;
