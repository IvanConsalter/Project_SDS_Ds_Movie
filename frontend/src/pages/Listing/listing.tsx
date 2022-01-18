import axios from "axios";
import MovieCard from "components/MovieCard/movieCard";
import Pagination from "components/Pagination/pagination";

import { useEffect, useState } from "react";

import { MoviePage } from "types/movie";

import { BASE_URL } from "utils/requests";

import { TailSpin } from  'react-loader-spinner';
import "react-loader-spinner/dist/loader/css/react-spinner-loader.css";

function Listing() {
  const [pageNumber, setPageNumber] = useState(0);
  const [loading, setLoading] = useState(false);
  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
      .then((response) => {
        const data = response.data as MoviePage;
        setPage(data);
        setLoading(true);
      });
  }, [pageNumber]);

  const handlePageChange = (newPageNumber: number) => {
    setPageNumber(newPageNumber);
  };

  return (
    <>
      <Pagination page={page} onChange={handlePageChange} />
      <div className="container">
        {loading ? (
          <div className="row mx-3">
            {page.content.map((movie) => (
              <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 my-3">
                <MovieCard movie={movie} />
              </div>
            ))}
          </div>
        ) : (
          <div className="d-flex justify-content-center mt-5">
            <TailSpin color="#E50914" height={80} width={80} />
          </div>
        )}
      </div>
    </>
  );
}

export default Listing;
