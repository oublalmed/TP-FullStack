import { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

const ModuleList = () => {
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    fetch('/modules')
      .then((resp) => resp.json())
      .then((d) => {
        setData(d);
        setIsLoading(false);
      });
  }, []);

  const remove = async (id) => {
    await fetch(`modules/${id}`, {
      method: 'DELETE',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
    }).then(() => {
      let updatedData = [...data].filter((mo) => mo.id !== id);
      setData(updatedData);
    });
  };

  const TableRows = (props) => {
    return (
      <>
        {props.data.map((module) => {
          return (
            <tr key={module.index}>
              <td style={{ whiteSpace: 'nowrap' }}>{module.id}</td>
              <td>{module.nom}</td>
              <td>{module.description}</td>
              <td>
                <ButtonGroup>
                  <Button
                    size="sm"
                    color="primary"
                    tag={Link}
                    to={'/modules/' + module.id}
                  >
                    Edit
                  </Button>
                  <Button
                    size="sm"
                    color="danger"
                    onClick={() => remove(module.id)}
                  >
                    Delete
                  </Button>
                </ButtonGroup>
              </td>
            </tr>
          );
        })}
      </>
    );
  };

  if (isLoading) return <p>Loading ...</p>;

  return (
    <div>
      <Container fluid>
        <div className="float-end">
          <Button color="success" tag={Link} to="/add">
            Add Module
          </Button>
        </div>
        <h3>List Of Modules</h3>
        <Table className="mt-4">
          <thead>
            <tr>
              <th width="20%">ID module</th>
              <th width="20%">Libelle module</th>
              <th>Description</th>
              <th width="10%">Actions</th>
            </tr>
          </thead>
          <tbody>
            <TableRows data={data} />
          </tbody>
        </Table>
      </Container>
    </div>
  );
};

{
  /* <table>
        <tbody>
          <TableRows data={data} />
        </tbody>
      </table> */
}

export default ModuleList;
