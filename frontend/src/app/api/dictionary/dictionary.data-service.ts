import {Observable} from 'rxjs';
import {DictionaryModel} from '../../models';

export abstract class DictionaryDataService {

  abstract fetch(): Observable<DictionaryModel>;

}
