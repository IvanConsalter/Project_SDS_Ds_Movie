import axios from "axios";
import MovieCard from "components/MovieCard/movieCard";
import Pagination from "components/Pagination/pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

  const [pageNumber, setPageNumber] = useState(0);

  useEffect( () => {
    axios.get(`${BASE_URL}/movies`)
    .then(
      response => {
        const data = response.data as MoviePage;
        console.log(data);
        
        setPageNumber(data.number);
      }
    )
  }, []);

  
  return (
    <>
      <Pagination />

      <div className="container">
        <div className="row">
          <div className="col-sm-6 col-lg-4 col-xl-3 my-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 my-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 my-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 my-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 my-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 my-3">
            <MovieCard />
          </div>
        </div>
      </div>
    </>
  );
}

export default Listing;
